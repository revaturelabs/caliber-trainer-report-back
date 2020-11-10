# Caliber Trainer Report Backend
## Description: 
Excaliber is a web application used to display trainer batch information in visually appealing charts. It is designed to take in a JSON file filled with a Trainer’s information and specific Batches data. It also has been refactored to take data from external api endpoints from a specified list of trainers.

### 9/22/2020: 
Batch 821 was assigned a job in order to refactor a legacy application. Our specific objectives were listed below
# BATCH 821 User Stories
- I should be able to pull report data directly from caliber if I do not wish to provide a JSON file with the appropriate data. (Completed)
- I should be able to view a calendar view for a selected trainer of the batches they have trained and are currently training. (Completed)
- Change the default view for the line graph I see should include all possible options displayed at once. (Completed)
- Refactor frontend chart naming scheme (Completed)
- Print to PDF functionality (Completed)
- Deploy on Revature provided EC2 with CI/CD (In progress)

# Prerequisites resources:
## Dependencies:
### Backend:
- Springboot
- Cucumber
  - Install through eclipse IDE marketplace
- junit
### Front End:
- [Node.js](https://nodejs.org/en/)
- Angular
  - `npm install angular`
- jquery
  - `npminstall jquery`
  - in angular.json add 
  - '"scripts": [\"node_modules/jquery/dist/jquery.min.js\"]'
- Bootstrap
  - `npm install --save bootstrap`
   -in index.html add `<link rel="stylesheet" href="../node_modules/bootstrap/dist/css/bootstrap.css">`
- chart.js
  - npm install --save chartjs
- Full Calendar API
  - `npm install --save @fullcalendar/core @fullcalendar/daygrid @fullcalendar/angular`
- html2pdf
  - `npm install --save html2pdf`
  
# Installation
## Backend:
- Run the server in your ide or terminal or build the package and run the java file
  - Java filename.jar
## Frontend:
- In the project's root directory run 'ng serve'

# Future Work
- Caching front end information
- Modularizing backend controllers
- Optimize JSON parsing

# Contributing
Revature batch 821

# License
MIT

# Documentation:
- [Backend Caliber Endpoints](https://github.com/revaturelabs/caliber-trainer-report-back/wiki/Backend-Caliber-Endpoints)
- [Get Batches By Trainer Function](https://github.com/revaturelabs/caliber-trainer-report-back/wiki/Get-Batches-By-Trainer-Function)
- [Front end graph functions](https://github.com/revaturelabs/caliber-trainer-report-front/wiki/Graph-(9-22-20))



