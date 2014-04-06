package ca.android;

public class Exercises {
		private String name;
		private String time;
		private String status;
		private String reps;
		
		public Exercises() {
			super();
		}

		public Exercises(String name, String time, String status, String reps) {
			super();
			this.name = name;
			this.time = time;
			this.status = status;
			this.reps = reps;
		}
		
		// Return exercise string
		@Override
		public String toString() {
			return this.name + "\t" + this.reps + " reps at " + this.time + " " + this.status;
		}
		
		
		// Access functions
		public String getName() {
			return name;
		}
		
		public String getTime() {
			return time;
		}
		
		public String getStatus() {
			return status;
		}
		
		public String getReps() {
			return reps;
		}
		
		// Mutators
		
		public void setName(String name) {
			this.name = name;
		}
		
		public void setTime(String time) {
			this.time = time;
		}
		
		public void setStatus(String status) {
			this.status = status;
		}
		
		public void setReps(String reps) {
			this.reps = reps;
		}
		
		
	}

