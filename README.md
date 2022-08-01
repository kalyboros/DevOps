# CT360 DevOps assignment 

DevOps learning module

## Getting Started


## Tasks
### Task 1: Introduction to Groovy and setting up local / Azure environment
I installed Ubuntu 22.04 LTS on VMWare. 

On the newly installed OS i did the initial upgrade and update, installed vsc, did some gnome tweaking, installed jdk and groovy. 

After that i created a .groovy file in which i have my notes and examples from learning groovy (lists, maps, nullsafe, ternary, regex ...).

Created an ubuntu virtual machine on azure (later i deleted it since i dont need it right now and it costs 0.09EUR/hr).

BONUS: I also created a shared library with a simple text output and built it in jenkins.

### Task 2: Introduction to Jenkins (Azure VM)
Different types of Jenkins Jobs:
 - tbd

Scripted & Declarative pipelines:
 - tbd

Jenkins agents and executors:
 - Agents are the worker nodes that actually execute all the steps mentioned in a Job. Upon Job creation we have to assign an agent to it.
 - Executor is a building block which allow a build to run on a node/agent. It is basically a "process ID".

Create a job that clones:
  - Demonstration

Create any three jobs, where first job calls the other two in parallel:
 - Demonstrate

Install a sample plugin:
 - Installed BlueOcean

Parametrized Jenkins jobs:
 - Demonstration



Links: 
 - https://www.youtube.com/watch?v=e1Y2sFW5nN0&ab_channel=Abhishek.Veeramalla
 - https://narenchejara.medium.com/create-jenkin-job-and-clone-project-from-git-b513804d3089
 - https://www.youtube.com/watch?v=hgqBGNPlLlU&ab_channel=AutomationStepbyStep

### Task 3: Introduction to Docker (on local or Azure VM)
Successfully installed docker on my VM.

Created an account on Docker Hub.

Difference between a docker image and docker container?
- Docker image is a package that includes everything needed to run as an application and is by itself executable. Information in the image provides on how a container should instantiate, which components to run and what to do with them. 
- Docker container is a virtual enviornment that bundles the application with all the code and dependencies required to run the app. 

Created a dockerfile, which builds an image of a lightweight alpineOS hello world setup

Basic Steps:
1. $cd /home/dali/Desktop/DevOps/docker
2. to build image run: $docker build -t dali_first_image .
3. to check if it was created run: $docker images
4. run the image as a container with $docker run --name dali_first_container dali_first_image

Saving to Repo steps:
1. to build image run: $docker build -t dali_first_image .
2. $docker login
3. docker image tag dali_first_image kalybor/dali_first_image:v1
4. docker image push kalybor/dali_first_image:v1

Image can be found here: https://hub.docker.com/repository/docker/kalybor/dali_first_image


What i learned about docker compose, swarm, stacks TO BE DONE.

Links: https://hemanta.io/how-to-push-a-docker-image-to-docker-hub/


### Task 4: CI/CD pipeline 
TO BE DONE

## Authors

Contributors names and contact info

* Dalibor Veselinovic
