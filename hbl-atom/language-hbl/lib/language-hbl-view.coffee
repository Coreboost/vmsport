module.exports =
class LanguageHblView
  constructor: (serializedState) ->
    # Create root element
    @element = document.createElement('div')
    @element.classList.add('language-hbl')
    this.addMessage("Hey ho, let's go!")

  # Returns an object that can be retrieved when package is activated
  serialize: ->

  # Tear down any state and detach
  destroy: ->
    @element.remove()

  getElement: ->
    @element

  clearMessages: ->
    while @element.childElementCount > 0
      @element.firstChild.remove()

  addMessage: (mess) ->
    message = document.createElement('div')
    message.textContent = mess
    message.classList.add('message')
    @element.appendChild(message)
