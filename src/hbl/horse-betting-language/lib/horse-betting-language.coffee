HorseBettingLanguageView = require './horse-betting-language-view'
{CompositeDisposable} = require 'atom'

module.exports = HorseBettingLanguage =
  horseBettingLanguageView: null
  modalPanel: null
  subscriptions: null

  activate: (state) ->
    @horseBettingLanguageView = new HorseBettingLanguageView(state.horseBettingLanguageViewState)
    @modalPanel = atom.workspace.addModalPanel(item: @horseBettingLanguageView.getElement(), visible: false)

    # Events subscribed to in atom's system can be easily cleaned up with a CompositeDisposable
    @subscriptions = new CompositeDisposable

    # Register command that toggles this view
    @subscriptions.add atom.commands.add 'atom-workspace', 'horse-betting-language:toggle': => @toggle()

  deactivate: ->
    @modalPanel.destroy()
    @subscriptions.dispose()
    @horseBettingLanguageView.destroy()

  serialize: ->
    horseBettingLanguageViewState: @horseBettingLanguageView.serialize()

  toggle: ->
    console.log 'HorseBettingLanguage was toggled!'

    if @modalPanel.isVisible()
      @modalPanel.hide()
    else
      @modalPanel.show()
