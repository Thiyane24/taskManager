public class Task {

        private  String id;
        private  String title;
        private  String status;

        public Task (String id, String title, String status){
            this.id = id;
            this.title = title;
            this.status = status;
        }

        String getId(){
            return this.id;
        }

        String getTitle(){
            return this.title;
        }

        String getStatus(){
            return this.status;
        }

        void setStatus(String status){
            this.status = status;
        }
}
