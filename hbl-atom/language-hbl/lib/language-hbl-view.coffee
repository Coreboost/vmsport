module.exports =
class LanguageHblView
  constructor: (serializedState) ->
    # Create root element
    @remainingMessage = "";
    @messageCount = 0
    @element = document.createElement('div')
    @element.classList.add('language-hbl')
    this.addMessages("Hey ho, let's go!\n")

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
    @messageCount = 0

  addMessages: (messages) ->
    if @messageCount < 10
      fullMessages = @remainingMessage + messages
      parts = fullMessages.split("\n")
      if fullMessages.slice(-1) is "\n"   # Check if string ends with newline...
        @remainingMessage = ""
        messageTexts = parts
      else
        [messageTexts..., @remainingMessage] = parts    # Set remainingMessage to the last part
      for messageText in messageTexts
        if @messageCount < 10
          message = document.createElement('div')
          message.textContent = messageText
          message.classList.add('message')
          @element.appendChild(message)
          @messageCount += 1
