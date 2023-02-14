public interface TodolistService {
    void  getAllTodo();
    void addTodo(String todo);
    boolean editTodo(int nomor, String todo);
    boolean removeTodo(int nomor);
    Todolist[] searchTodo(String keyword);
}
