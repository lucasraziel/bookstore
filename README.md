## Bookstore  [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=lucasraziel_bookstore&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=lucasraziel_bookstore) [![codecov](https://codecov.io/gh/lucasraziel/bookstore/branch/main/graph/badge.svg?token=YIM0CZ5YOD)](https://codecov.io/gh/lucasraziel/bookstore) ![Known Vulnerabilities](https://snyk.io/test/github/lucasraziel/bookstore/badge.svg)

#### <p align="center"> Requirements </p>
<div align="center"> 
    <a href="https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html" target"_blank">:coffee: Java 18 </a>
</div>

#### <p align="center">  Description </p>

This is a project for educational purpose. This app will be a REST API for a bookstore. The main purpose is to develop this app using the best practices of clean architecture using Domain Driven Design.


Please, read the content below to know how to use this api and if is there any doubt, please, contact me.

#### <p align="center"> PR Advices </p>

You'll see that once you open a PR some checks will be made, they are all essential to be passed before you merge your branch, so, make sure they are all passing.

One exception is snyk, which sometimes have some problems that can't be solved now, in this case you can just bypass.

#### <p align="center">  Using Cloud Tools </p>

* Snyk
  * Just click in the link above and search for starwars-api-java, so you will be able to see the security problems.
* SonarCloud
  * Clicking the link above you will be redirected to the quality analysis of this project.
* CodeCov
  * You can click the link above and see the code coverage details by commit or any type of data or just see the summary
    in your PR.
    
#### <p align="center"> Documents for implementation </p>

##### User Stories

[Create Storage Plan](https://github.com/lucasraziel/bookstore/blob/063bf09b6762473cf453d6c7cfb287471e2c7a73/userstories/createStoragePlan.md)

##### Diagrams

Use Case for Create Storage Plan

![logo](https://user-images.githubusercontent.com/26093830/172564307-ddc56fcf-3c3b-4127-bc5c-6b626bcdb2fa.jpeg)
#### <p align="center"> Running </p>

Context Map

![logo](https://user-images.githubusercontent.com/26093830/172564202-7cde416e-b932-4fb3-a4f2-178e805d222a.png)

Entities for Create User Repsitory

![logo](https://user-images.githubusercontent.com/26093830/172564376-41198f82-1172-462f-8685-f46e5a4c9bb9.png)

#### <p align="center"> Running </p>

Execute the following command to run the tests:

```
chmod +x ./scripts/test.sh && ./scripts/test.sh
```

