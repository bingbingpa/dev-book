package ch06.item36.composition

class Progress {
    fun showProgress() { /* show progress */ }

    fun hideProgress() { /* hide progress */ }
}

class FinishedAlert {
    fun show() { /**/ }
}


class ProfileLoader {
    private val progress = Progress()

    fun load() {
        progress.showProgress()
        // 프로파일을 읽어 들임
        progress.hideProgress()
    }
}

class ImageLoader {
    private val progress = Progress()
    private val finishedAlert = FinishedAlert()

    fun load() {
        progress.showProgress()
        // 이미지를 읽어 들임
        progress.hideProgress()
        finishedAlert.show()
    }
}
