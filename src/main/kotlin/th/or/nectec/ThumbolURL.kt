package th.or.nectec

/**
 * How To Parameter
 * https://thumbor.readthedocs.io/en/latest/filters.html
 */
class ThumbolURL(// = "http://localhost:8000"
        var hosturl: String,
        var imagename: String) {

    //http://localhost:8000/unsafe/trim/fit-in/500x500/filters:blur(7,0):brightness(10)/1.jpg

    var hmac_auth: String? = null
    var background_color: String? = null
    var blur: Int = 0
    var blur_sigma: Int = 0
    var brightness: Int = 0
    var contrast: Int = 0
    var equalize: Boolean = false
    var format: String? = null
    var grayscale: Boolean = false
    var rgb_amount: RGB_Amount = RGB_Amount()
    var rotate: Int = 0
    var strip_icc: Boolean = false
    var max_bytes: Long? = null
    var no_upscale: Boolean = false
    var noise: Int = 0
    var quality: Int? = null
    var watermark :Watermark = Watermark()



    fun getUrl(): String {
        var genurl = hosturl
        genurl += hmac_AuthFilter()
        genurl += addFilter()
        genurl += "/" + imagename
        return genurl
    }

    private fun addFilter(): String {
        var filter = "/filters"
        filter += backgroundColorFilter()
        filter += blurFilter()
        filter += brightnessFilter()
        filter += contrastFilter()
        filter += equalizeFilter()
        filter += formatFilter()
        filter += grayscaleFilter()
        filter += maxBytesFilter()
        filter += noUpscaleFilter()
        filter += noiseFilter()
        filter += qualityFilter()
        filter += rgbAmountFilter()
        filter += rotateFilter()
        filter += stripIccFilter()
        return if (!filter.endsWith("/filters")) filter else ""
    }

    private fun hmac_AuthFilter(): String {
        return if (hmac_auth != null) {
            "/" + hmac_auth
        } else "/unsafe"
    }


    private fun backgroundColorFilter(): String {
        return if (background_color != null) {
            ":background_color(" + background_color + ")"
        } else ""
    }


    private fun blurFilter(): String {
        return if (blur != 0) {
            ":blur(" + blur.toString() + "," + blur_sigma + ")"
        } else ""
    }


    private fun brightnessFilter(): String {
        return if (brightness != 0) {
            ":brightness(" + brightness + ")"
        } else ""
    }

    private fun contrastFilter(): String {
        return if (contrast != 0) {
            ":contrast(" + contrast + ")"
        } else ""
    }

    private fun equalizeFilter(): String {
        return if (equalize) {
            ":equalize()"
        } else ""
    }


    private fun formatFilter(): String {
        return if (format != null) {
            ":format(" + format + ")"
        } else ""
    }

    private fun grayscaleFilter(): String {
        return if (grayscale) {
            ":grayscale()"
        } else ""
    }

    private fun rgbAmountFilter(): String {
        return if ((rgb_amount.rAmount or rgb_amount.gAmount or rgb_amount.bAmount) != 0) {
            ":rgb(" + rgb_amount.rAmount + "," + rgb_amount.gAmount + "," + rgb_amount.bAmount + ")"
        } else ""
    }


    private fun rotateFilter(): String {
        return if (rotate != 0) {
            ":rotate(" + rotate + ")"
        } else ""
    }
    private fun maxBytesFilter(): String {
        return if (max_bytes != null) {
            ":max_bytes(" + max_bytes + ")"
        } else ""
    }

    private fun noUpscaleFilter(): String {
        return if (no_upscale) {
            ":no_upscale()"
        } else ""
    }


    private fun noiseFilter(): String {
        return if (noise != 0) {
            ":noise(" + noise + ")"
        } else ""
    }


    private fun qualityFilter(): String {
        return if (quality != null) {
            ":quality(" + quality + ")"
        } else ""
    }

    private fun stripIccFilter(): String {
        return if (strip_icc) {
            ":strip_icc()"
        } else ""
    }

    class Filters

    class Watermark{
        var imageurl :String=""
        var x :Int =-10
        var y :Int =-10
        var alpha :Int =50
    }
    class RGB_Amount {
        var rAmount: Int = 0
        var gAmount: Int = 0
        var bAmount: Int = 0
    }
}


/*
    hmac_keyAUTH	String?	null

    background_color	String?	null

    blur	Int	0
    blur_sigma	Int	0
    brightness	Int	0
    contrast	Int	0

    equalize	Boolean	false

    format	String?	null

    grayscale	Boolean	false

    max_bytes	Long?	null

    no_upscale	Boolean	false

    noise	Int	0
    quality	Int?	null
    red_eye	Boolean	false

    rAmount	Int	0
    gAmount	Int	0
    bAmount	Int	0

    rotate	Int	0

    strip_icc	Boolean	false

 */


