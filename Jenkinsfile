#!/usr/bin/env groovy

def gv
pipeline {
    agent any
    tools{
        jdk 'myjava'
        maven 'mymaven'
    }
    stages {
        stage("init"){
            steps{
                script{
                    gv = load "script.groovy"
                }
            }
        }
        stage('build') {
            steps {
                script {
                   gv.buildJar()
                }
            }
        }
        stage('build docker image') {
            steps {
                script {
                   gv.buildImage()

                }
            }
        }
        stage('deploy') {
            steps {
                script {
                   gv.deployApp()
                }
            }
        }
    }
}
