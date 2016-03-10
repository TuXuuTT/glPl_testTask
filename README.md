execute maven task with Valid credentials:

mvn clean test -Duser.login="\<loginName\>" -Duser.password="\<loginPassword\>"

Chrome is used as default browser. If you want to run in firefox, just add to command line:

-DbrowserClient=ff

Note:
In case of provding invalid credentials test will fail. For testing negative scenario there should be another test method
