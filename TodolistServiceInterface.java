public class TodolistServiceInterface implements TodolistService{
    TodolistRepository repository = new TodolistRepositoryImpl();

    private Todolist[] todolists = repository.getAllTodo();

    public TodolistServiceInterface(TodolistRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getAllTodo() {
        for (int i = 0; i < todolists.length ; i++) {
            System.out.println((i+1)+". "+ todolists[i].getNama());
        }
    }

    @Override
    public void addTodo(String todo) {
        repository.addTodo(new Todolist(todo));
    }

    @Override
    public boolean editTodo(int nomor, String todo) {
        return repository.editTodo(nomor,new Todolist(todo));
    }

    @Override
    public boolean removeTodo(int nomor) {
        return repository.removeTodo(nomor);
    }

    @Override
    public Todolist[] searchTodo(String keyword) {
        return repository.searchTodo(keyword);
    }
}
