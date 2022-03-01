package ch06.item36.extends

abstract class LoaderWithProgress {
    fun load() {
        // 프로그레스 바를 보여줌
        innerLoad()
        // 프로그레스 바를 숨김
    }
    abstract fun innerLoad()
}

abstract class InternetLoader(val showAlert: Boolean) {
    fun load() {
        // 프로그레스 바를 보여줌
        innerLoad()
        // 프로그레스 바를 숨김
        if (showAlert) {
            // 경고창 출력
        }
    }
    abstract fun innerLoad()
}

class ProfileLoader : InternetLoader(showAlert = true) {
    override fun innerLoad() {
        // 프로파일을 읽어 들임
    }
}

class ImageLoader : InternetLoader(showAlert = false) {
    override fun innerLoad() {
        // 이미지를 읽어 들임
    }
}