/**
 * Event Class
 * 
 * @author Nikki McCloud
 * @version 1.0
 */
package Model;

public class Event {
	// Declaring Alert Variable
		private Object obj;

		/**
		 * Default No Argument Constructor
		 */
		public Event() {
		}

		/**
		 * Getter for obj
		 * 
		 * @return obj
		 */
		public Object getObj() {
			return obj;
		}

		/**
		 * Setter for obj
		 * 
		 * @param obj
		 */
		public void setObj(Object obj) {
			this.obj = obj;
		}

		/**
		 * Timer Event Method
		 * 
		 * @param obj
		 * @return obj
		 */
		public Event(Object obj) {
			this.obj = obj;
		}
	}
