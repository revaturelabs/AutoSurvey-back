package com.revature.controllers;

public class QuestionControllerImpl implements QuestionController {
<<<<<<< Updated upstream
=======

	@Autowired
	QuestionService qs;

	@Override
	@GetMapping(value = "/question/{id}")
	public Question getQuestion(@PathVariable("id") int id) {
		try {
			return qs.getQuestion(id);
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException in QuestionControllerImpl.getQuestion");
		}
		return null;
	}

	@Override
	@GetMapping(value = "/question", produces = "application/json")
	public List<Question> getAllQuestions() {
		try {
			return qs.getAllQuestions();
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException in QuestionControllerImpl.getAllQuestions");
		}
		return null;
	}

	@Override
	@GetMapping(value = "/questionByCreatedOn/{createdOn}", produces = "application/json")
	public List<Question> getQuestionsByCreatedOn(Timestamp createdOn) {
		try {
			return qs.getQuestionsByCreatedOn(createdOn);
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException in QuestionControllerImpl.getQuestionsByCreatedOn");
		}
		return null;
	}

	@Override
	@PostMapping(value = "/question", consumes = "application/json", produces = "application/json")
	public Question addQuestion(Question q) {
		try {
			return qs.addQuestion(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@PutMapping(value = "/question/{id}", consumes = "application/json", produces = "application/json")
	public Question updateQuestion(Question q) {
		try {
			return qs.updateQuestion(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@DeleteMapping(value = "/question/{id}")
	public boolean deleteQuestion(int id) {
		try {
			return qs.deleteQuestion(id);
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException in QuestionControllerImpl.deleteQuestion");
		}
		return false;
	}
>>>>>>> Stashed changes

}
