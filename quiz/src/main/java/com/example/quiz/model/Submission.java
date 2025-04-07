	package com.example.quiz.model;
	
	import jakarta.persistence.*;
	
	@Entity
	@Table(name = "submissions")
	public class Submission {
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @ManyToOne
	    @JoinColumn(name = "user_id", nullable = false)
	    private User user;
	
	    @ManyToOne
	    @JoinColumn(name = "quiz_id", nullable = false)
	    private Quiz quiz;
	
	    private int score; // Store calculated marks
	
		public Long getId() {
			return id;
		}
		
		public void setId(Long id) {
			this.id = id;
		}
	
		public User getUser() {
			return user;
		}
	
		public void setUser(User user) {
			this.user = user;
		}
	
		public Quiz getQuiz() {
			return quiz;
		}
	
		public void setQuiz(Quiz quiz) {
			this.quiz = quiz;
		}
	
		public int getScore() {
			return score;
		}
	
		public void setScore(int score) {
			this.score = score;
		}
		
		public Submission() {};
	
		public Submission(Long id, User user, Quiz quiz, int score) {
			super();
			this.id = id;
			this.user = user;
			this.quiz = quiz;
			this.score = score;
		}
	    
	    
	
	}
