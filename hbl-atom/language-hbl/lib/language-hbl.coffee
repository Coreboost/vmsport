LanguageHblView = require './language-hbl-view'
{CompositeDisposable} = require 'atom'

module.exports = LanguageHbl =
  languageHblView: null
  modalPanel: null
  subscriptions: null

  activate: (state) ->
    @languageHblView = new LanguageHblView(state.languageHblViewState)
    @errorPane = atom.workspace.addBottomPanel(item: @languageHblView.getElement(), visible: false, className:'atom-hbl-pane')

    # Events subscribed to in atom's system can be easily cleaned up with a CompositeDisposable
    @subscriptions = new CompositeDisposable

    # Register command that toggles this view
    @subscriptions.add atom.commands.add 'atom-workspace', 'language-hbl:toggle': => @toggle()
    @subscriptions.add atom.commands.add 'atom-workspace', 'language-hbl:validate': => @validate()

  deactivate: ->
    @errorPane.destroy()
    @subscriptions.dispose()
    @languageHblView.destroy()

  serialize: ->
    languageHblViewState: @languageHblView.serialize()

  toggle: ->

    if @errorPane.isVisible()
      @errorPane.hide()
    else
      @errorPane.show()

  validate: ->
      if not @errorPane.isVisible() then @errorPane.show()
      @languageHblView.clearMessages()
      hblView = @languageHblView
      spawn = require('child_process').spawn
      child = spawn('ls', ['/'])
      child.stdout.on('data', (data) -> hblView.addMessage(data.toString()) )
      child.stderr.on('data', (data) -> hblView.addMessage(data.toString()) )
      child.on('close', (code) -> hblView.addMessage("Finished with exit code " + code) )
