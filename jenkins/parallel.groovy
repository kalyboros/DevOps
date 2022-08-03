pipeline {
    agent any

    stages {
        stage ("Paralel job calling scenario"){
            parallel {
                stage('Clone git job'){
                    steps {
                        echo 'Cloning project'
                        script{
                            build job: 'Maven-Job'
                        }
                        sleep 5
                    }
                }

                stage('Maven job'){
                    steps {
                        echo 'Building maven project'
                        script{
                            build job: 'Clone-Project-From-Git'
                        }
                        sleep 5
                    }
                }
            }
        }
    }
}