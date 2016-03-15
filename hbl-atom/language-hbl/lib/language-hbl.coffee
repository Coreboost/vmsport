LanguageHblView = require './language-hbl-view'
{CompositeDisposable} = require 'atom'
child_process = require 'child_process'


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
    @errorPane.show()
    @languageHblView.clearMessages()
    editor = atom.workspace.getActiveTextEditor();
    if editor
      childProcess = child_process.spawnSync('hblc', ['-i', '-'], { input: editor.getText() })
      if childProcess.status == 0
        @languageHblView.addMessages("Success!!\n")
      else
        @languageHblView.addMessages(String.fromCharCode.apply(null, childProcess.stderr))
