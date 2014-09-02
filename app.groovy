@Grapes([
    @Grab("org.gebish:geb-core:0.9.3"),
    @Grab("org.seleniumhq.selenium:selenium-htmlunit-driver:2.41.0"),
    @Grab("org.seleniumhq.selenium:selenium-support:2.41.0")
])
import geb.Browser
 
Browser.drive{
    driver.webClient.javaScriptEnabled = true
    go "http://encodable.com/uploaddemo/"     
    waitFor { title.endsWith("Upload a file") }
    def f = $('#theuploadform')
    def submit = $('#uploadbutton')
    f.uploadname1 = new File(System.getProperty('user.home'),'Desktop').absolutePath + '/GebDemo.groovy'
    f.subdir1 = '/'
    f.newsubdir1 = 'gebdemo'
    js.exec('$(\'#theuploadform\').submit()')
    
    println "DONE"
}
