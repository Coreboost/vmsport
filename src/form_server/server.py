import time
import json
from threading import Thread
from flask import Flask, render_template
import socketio

sio = socketio.Server(logger=True, async_mode='threading')
app = Flask(__name__)
app.wsgi_app = socketio.Middleware(sio, app.wsgi_app)
app.config['SECRET_KEY'] = 'HejPaaDigEvert!'

@app.route('/')
def index():
    return render_template('index.html')


@sio.on('load form', namespace='/ifdl')
def load_form(sid, message):
    print "Load form" + message
    sio.emit('initialize form', message, room=sid,
             namespace='/ifdl')

@sio.on('my broadcast event', namespace='/ifdl')
def test_broadcast_message(sid, message):
    sio.emit('my response', {'data': message['data']}, namespace='/ifdl')

@sio.on('disconnect request', namespace='/ifdl')
def disconnect_request(sid):
    sio.disconnect(sid, namespace='/ifdl')

@sio.on('connect', namespace='/ifdl')
def test_connect(sid, environ):
    with open('forms/forms.json', 'r') as content_file:
        content = content_file.read()
        forms = json.loads(content)
    sio.emit('forms', forms, room=sid, namespace='/ifdl')

@sio.on('disconnect', namespace='/ifdl')
def test_disconnect(sid):
    print('Client disconnected')

if __name__ == '__main__':
    # deploy with Werkzeug
    app.run(threaded=True)
