LanguageHblView = require './language-hbl-view'
{CompositeDisposable} = require 'atom'

module.exports = LanguageHbl =
  languageHblView: null
  modalPanel: null
  subscriptions: null

  activate: (state) ->
    @languageHblView = new LanguageHblView(state.languageHblViewState)
    @modalPanel = atom.workspace.addModalPanel(item: @languageHblView.getElement(), visible: false)

    # Events subscribed to in atom's system can be easily cleaned up with a CompositeDisposable
    @subscriptions = new CompositeDisposable

    # Register command that toggles this view
    @subscriptions.add atom.commands.add 'atom-workspace', 'language-hbl:toggle': => @toggle()

  deactivate: ->
    @modalPanel.destroy()
    @subscriptions.dispose()
    @languageHblView.destroy()

  serialize: ->
    languageHblViewState: @languageHblView.serialize()

  toggle: ->
    console.log 'LanguageHbl was toggled!'

    if @modalPanel.isVisible()
      @modalPanel.hide()
    else
      @modalPanel.show()
