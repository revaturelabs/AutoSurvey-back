package com.revature.services;

public class QuestionServiceImpl implements QuestionService {

<<<<<<< Updated upstream
=======
	@Autowired
	QuestionRepo qr;
	
	@Override
	public Question getQuestion(int id) {
		return qr.findById(id).get();
	}

	@Override
	public List<Question> getAllQuestions() {
		return (List<Question>) qr.findAll();
	}

	@Override
	public List<Question> getQuestionsByCreatedOn(Timestamp createdOn) {
		return qr.findByCreatedOn(createdOn);
	}

	@Override
	public Question addQuestion(Question q) {
		return qr.save(q);
	}

	@Override
	public Question updateQuestion(Question q) {
		return qr.save(q);
	}

	@Override
	public boolean deleteQuestion(int id) {
		qr.delete(qr.findById(id).get());
		return true;
	}

>>>>>>> Stashed changes
}
