package com.revature.beans;

import org.springframework.stereotype.Component;

@Component
public class Statistic {
	
	public double avgSatisfaction;
	public double avgUnderstanding;
	public double avgPace;
	public double avgHelpful;
	public double avgOrganized;
	public double avgQuestionsEncouraged;
	public double avgMetExpectations;
	
	public int satisfactionCount;
	public int understandingCount;
	public int paceCount;
	public int helpfulCount;
	public int organizedCount;
	public int questionsEncouragedCount;
	public int metExpectationsCount;
	
	public Statistic() {
		super();
	}

	public double getAvgSatisfaction() {
		return avgSatisfaction;
	}

	public void setAvgSatisfaction(double avgSatisfaction) {
		this.avgSatisfaction = avgSatisfaction;
	}

	public double getAvgUnderstanding() {
		return avgUnderstanding;
	}

	public void setAvgUnderstanding(double avgUnderstanding) {
		this.avgUnderstanding = avgUnderstanding;
	}

	public double getAvgPace() {
		return avgPace;
	}

	public void setAvgPace(double avgPace) {
		this.avgPace = avgPace;
	}

	public double getAvgHelpful() {
		return avgHelpful;
	}

	public void setAvgHelpful(double avgHelpful) {
		this.avgHelpful = avgHelpful;
	}

	public double getAvgOrganized() {
		return avgOrganized;
	}

	public void setAvgOrganized(double avgOrganized) {
		this.avgOrganized = avgOrganized;
	}

	public double getAvgQuestionsEncouraged() {
		return avgQuestionsEncouraged;
	}

	public void setAvgQuestionsEncouraged(double avgQuestionsEncouraged) {
		this.avgQuestionsEncouraged = avgQuestionsEncouraged;
	}

	public double getAvgMetExpectations() {
		return avgMetExpectations;
	}

	public void setAvgMetExpectations(double avgMetExpectations) {
		this.avgMetExpectations = avgMetExpectations;
	}

	public int getSatisfactionCount() {
		return satisfactionCount;
	}

	public void setSatisfactionCount(int satisfactionCount) {
		this.satisfactionCount = satisfactionCount;
	}

	public int getUnderstandingCount() {
		return understandingCount;
	}

	public void setUnderstandingCount(int understandingCount) {
		this.understandingCount = understandingCount;
	}

	public int getPaceCount() {
		return paceCount;
	}

	public void setPaceCount(int paceCount) {
		this.paceCount = paceCount;
	}

	public int getHelpfulCount() {
		return helpfulCount;
	}

	public void setHelpfulCount(int helpfulCount) {
		this.helpfulCount = helpfulCount;
	}

	public int getOrganizedCount() {
		return organizedCount;
	}

	public void setOrganizedCount(int organizedCount) {
		this.organizedCount = organizedCount;
	}

	public int getQuestionsEncouragedCount() {
		return questionsEncouragedCount;
	}

	public void setQuestionsEncouragedCount(int questionsEncouragedCount) {
		this.questionsEncouragedCount = questionsEncouragedCount;
	}

	public int getMetExpectationsCount() {
		return metExpectationsCount;
	}

	public void setMetExpectationsCount(int metExpectationsCount) {
		this.metExpectationsCount = metExpectationsCount;
	}

	@Override
	public String toString() {
		return "Statistic [avgSatisfaction=" + avgSatisfaction + ", avgUnderstanding=" + avgUnderstanding + ", avgPace="
				+ avgPace + ", avgHelpful=" + avgHelpful + ", avgOrganized=" + avgOrganized
				+ ", avgQuestionsEncouraged=" + avgQuestionsEncouraged + ", avgMetExpectations=" + avgMetExpectations
				+ "]";
	}
	
	

}
