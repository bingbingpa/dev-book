package ch5

class Application(
    private var preferences: UserPreferences
) {
    fun showWelcome() {
        WelcomeView(preferences).show()
    }

    fun editPreferences() {
        this.preferences = PreferencesView().showModal(preferences)
    }
}