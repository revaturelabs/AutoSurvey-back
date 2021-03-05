function submitSurveyToServer() {
  let xhttp = new XMLHttpRequest();

  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      let xhttp2 = new XMLHttpRequest();

      //Received Survey
      var survey = JSON.parse(this.responseText);

      // The following will populate answer JSON,
      // can be dynamically implemented further
      var answers = [
        document.getElementById("name").value,
        document.getElementById("email").value,
        document.getElementById("location").value,
        document.getElementById("batch").value,
        document.getElementById("week").value,
        document.querySelector('input[name="understanding"]:checked').value,
        document.querySelector('input[name="one-on-one"]:checked').value,
        document.querySelector('input[name="understanding"]:checked').value,
        document.querySelector('input[name="pace"]:checked').value,
        document.querySelector('input[name="helpfulMaterials"]:checked').value,
        document.querySelector('input[name="wellOrganized"]:checked').value,
        document.querySelector('input[name="questionsEncouraged"]:checked')
          .value,
        document.querySelector('input[name="metExpectations"]:checked').value,
        document.getElementById("issues").value,
        document.getElementById("week").value,
      ];

      //Formatting Response object answers
      var responseAnswers = [];

      //Will iterate through length of Survey Questions
      //And add Answers to DB, then return answer and
      //add it to the response JSON
      for (let j = 0; j < survey.questions.length; j++) {
        let answer = {
          id: 0,
          question: survey.questions[j],
          content: answers[j],
        };
        responseAnswers.push(answer);
      }

      var response = {
        id: 0,
        submittedAt: null,
        timeStampString: null,
        answers: responseAnswers,
        survey: survey,
      };

      xhttp2.onreadystatechange = function () {
        if (this.status == 200 && this.readyState == 4) {
          console.log(this.responseText);
        }
      };
      console.log(response);

      //Call For Response
      xhttp2.open(
        "POST",
        "http://ec2-54-173-212-237.compute-1.amazonaws.com:8080/AutoSurvey/responseSurvey",
        true
      );
      xhttp2.setRequestHeader("Content-Type", "application/json");
      xhttp2.send(JSON.stringify(response));
    }
    if (this.readyState == 3) {
      console.log(3);
    }
    if (this.readyState == 2) {
      console.log(2);
    }
    if (this.readyState == 1) {
      console.log(1);
    }
  };
  // This is the ID = 27748 retrieve survey
  let surveyId = 28050;
  xhttp.open(
    "GET",
    `http://ec2-54-173-212-237.compute-1.amazonaws.com:8080/AutoSurvey/surveys/${surveyId}`,
    true
  );
  xhttp.send();
}
