public interface TodolistRepository{
    Todolist[] getAllTodo();
    void addTodo(Todolist todolist);
    boolean editTodo(int nomor, Todolist todolist);
    boolean removeTodo(int nomor);
    Todolist[] searchTodo(String keyword);
}
