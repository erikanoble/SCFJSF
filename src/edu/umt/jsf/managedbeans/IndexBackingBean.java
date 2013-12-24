package edu.umt.jsf.managedbeans;

public class IndexBackingBean {

		public String listUserTypesAction(){
			return "list-usertypes";
		}
		
		public String listUsersAction(){
			return "list-users";
		}
	
		public String listApplicationsAction(){
			return "list-applications";
		}
		
		public String addUserTypesAction(){
			return "new-usertype";
		}
		
		public String addUsersAction(){
			return "new-user";
		}
		
		public String addApplicationsAction(){
			return "new-application";
		}

        public String deleteApplicationsAction(){
            return "delete-application";
        }

        public String deleteUsersAction(){
            return "delete-users";
        }

        public String deleteUserTypesAction(){
            return "delete-usertype";
        }

}
