package ch5

import java.util.*

class PreferencesView : View() {
    private val greetingPicker = GreetingPicker()
    private val localePicker = LocalePicker()
    private val currencyPicker = CurrencyPicker()

    fun showModal(preferences: UserPreferences): UserPreferences {
        greetingPicker.greeting = preferences.greeting
        localePicker.locale = preferences.locale
        currencyPicker.currency = preferences.currency
        show()
        return preferences
    }
}

internal class GreetingPicker {
    var greeting: String = ""
}

internal class LocalePicker {
    var locale: Locale = Locale.UK
}

internal class CurrencyPicker {
    var currency: Currency = Currency.getInstance(Locale.UK)
}