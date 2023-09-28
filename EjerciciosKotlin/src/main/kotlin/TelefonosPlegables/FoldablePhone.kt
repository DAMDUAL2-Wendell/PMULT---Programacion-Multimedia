package TelefonosPlegables

class FoldablePhone():Phone(){
    var folded: Boolean = true
    override fun switchOn() {
        if(!folded) isScreenLightOn = true else isScreenLightOn = false
    }
    fun changeFoldStatus(){
        if(folded) folded=false else folded=true
    }

}