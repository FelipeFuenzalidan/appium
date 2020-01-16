# Appium project in java language.
![N|Solid](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT-Ckfyk55DtL1a9EApX84jIzIduzXb2qYbtAlVUtUDWhvnbyYX)

### Set up work environment on mac
Open a terminal and run:
* `ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"`
* `brew install node`
* `npm install -g appium`
* `brew install android-sdk`

### Add Environment Variables
* Based on your shell, you need to edit your profile. e.g. `$ vi ~/.bash_profile or ~/.profile or ~/.zshrc`.
* Add the following variables.
	* `export ANDROID_HOME=/usr/local/Caskroom/android-sdk`
	* `export JAVA_HOME=$(/usr/libexec/java_home)`
  * Add the Android sdk paths to your existing PATH=$PATH variable `export      PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools:$ANDROID_HOME/build-tools/25.0.2`
  
### Running Test
* Open a terminal and run `appium`
* Navegate to the test -> test
