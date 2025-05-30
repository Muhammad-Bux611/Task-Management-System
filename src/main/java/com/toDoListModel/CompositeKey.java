package com.toDoListModel;
import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class CompositeKey implements Serializable {
		String title;
		String email;
		
		
		
//		public CompositeKey(String title, String email) {
//			
//			this.title = title;
//			this.email = email;
//		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		@Override
		public String toString() {
			return "CompositeKey [title=" + title + ", email=" + email + "]";
		}
		@Override
		 public boolean equals(Object o) {
		        if (this == o) return true;
		        if (!(o instanceof CompositeKey)) return false;
		        CompositeKey that = (CompositeKey) o;
		        return Objects.equals(email, that.email) &&
		               Objects.equals(title, that.title);
		    }

		    @Override
		    public int hashCode() {
		        return Objects.hash(email, title);
		    }		
}
