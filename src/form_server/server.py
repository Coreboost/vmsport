import time
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


@sio.on('my event', namespace='/ifdl')
def test_message(sid, message):
    sio.emit('my response', {'data': message['data']}, room=sid,
             namespace='/ifdl')


@sio.on('my broadcast event', namespace='/ifdl')
def test_broadcast_message(sid, message):
    sio.emit('my response', {'data': message['data']}, namespace='/ifdl')


@sio.on('disconnect request', namespace='/ifdl')
def disconnect_request(sid):
    sio.disconnect(sid, namespace='/ifdl')


@sio.on('connect', namespace='/ifdl')
def test_connect(sid, environ):
    sio.emit('forms', {'forms': ['One form', 'Another form', 'Mileage form'],}, room=sid,
             namespace='/ifdl')


@sio.on('disconnect', namespace='/ifdl')
def test_disconnect(sid):
    print('Client disconnected')

if __name__ == '__main__':
    # deploy with Werkzeug
    app.run(threaded=True)
