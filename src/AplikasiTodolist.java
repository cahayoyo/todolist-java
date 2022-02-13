public class AplikasiTodolist {

    public static String[] model = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    // Menampilkan todo List
    public static void showTodoList(){
        System.out.println("ToDo List");
        for (int i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if (todo != null){
                System.out.println(no + ". " + todo);
            }
        }
    }


    // Menambah todo List
    public static void addTodoList(String todo){
        // cek apakah model penuh
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null){
                isFull = false;
            }
        }

        // meresize array
        if (isFull){
            var temp = model;
            model = new String[model.length * 2];
            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }


        // tambahkan ke posisi yang data array null
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }


    // Menghapus todo list
    public static boolean removeTodoList(Integer number){
        if((number - 1) > model.length){
            return false;
        } else if (model[number - 1] == null){
            return false;
        } else {
            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length-1)){
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }


    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }


    // Menampilkan view todo list
    public static void viewShowTodoList(){
        while (true){
            showTodoList();

            System.out.println("Menu");
            System.out.println("1. Add Todo List");
            System.out.println("2. Remove Todo List");
            System.out.println("x. Exit");

            var input = input("Input");

            if(input.equals("1")){
                viewAddTodoList();
            } else if (input.equals("2")){
                viewRemoveTodoList();
            } else if (input.equals("x")){
                break;
            }else {
                System.out.println("Wrong Input");
            }
        }

    }


    // Menampilkan view menambah todo list
    public static void viewAddTodoList(){
        System.out.println("ADD TODO");

        var todo = input("TODO (input x if want to cancel)");
        if (todo.equals("x")){
            // cancel
        } else {
            addTodoList(todo);
        }
    }


    // Menampilkan view menghapus todo list
    public static void viewRemoveTodoList(){
        System.out.println("REMOVE TODO");

        var number = input("Number you want to delete (input x if want to cancel)");
        if (number.equals("x")){
            // cancel
        } else {
            var success = removeTodoList(Integer.valueOf(number));
            if (!success){
                System.out.println("Failed to delete todolist number " + number);
            }
        }
    }


    // TESTING FUNCTION
    public static void testShowTodoList(){
        model[0] = "Sinatra";
        model[1] = "jaywon";
        showTodoList();
    }

    public static void testAddTodoList(){
        for (int i = 0; i < 25; i++) {
            addTodoList("TodoList ke - " + i);
        }
        showTodoList();
    }

    public static void testRemoveTodoList(){
        addTodoList("ONE");
        addTodoList("TWO");
        addTodoList("THREE");
        addTodoList("FOUR");

        var result = removeTodoList(5);
        System.out.println(result);

        result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(3);
        System.out.println(result);

        showTodoList();
    }

    public static void testInput(){
        var data = input("Nama");
        System.out.println("Hi " + data);
    }

    public static void testViewShowTodoList(){
        for (int i = 0; i < 5; i++) {
            addTodoList("TODOLIST KE - " + i);
        }

        viewShowTodoList();
    }

    public static void testViewAddTodoList(){
        addTodoList("1");
        addTodoList("2");
        viewAddTodoList();

        showTodoList();
    }

    public static void testViewRemoveTodoList(){
        addTodoList("HIJI");
        addTodoList("DUA");
        addTodoList("TILU");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();

    }


}

