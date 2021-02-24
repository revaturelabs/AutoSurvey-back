package com.revature.services;

public class ResponseServiceImpl implements ResponseService {

<<<<<<< Updated upstream
=======
	@Autowired
	ResponseRepo rr;

	@Override
	public Response addResponse(Response r) {
		try {
			return rr.save(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Response getResponse(int id) {
		try {
			return rr.findById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Response> getAllResponse() {
		try {
			return (List<Response>) rr.findAll();
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public boolean updateResponse(Response r) {
		try {
			if (rr.save(r) != null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteResponse(int id) {
		// TODO Auto-generated method stub
		try {
			rr.delete(rr.findById(id).get());
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

>>>>>>> Stashed changes
}
