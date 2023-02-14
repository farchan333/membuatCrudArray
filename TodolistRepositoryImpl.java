import java.util.ArrayList;
import java.util.List;

public class TodolistRepositoryImpl implements TodolistRepository {

    Todolist[] todolists = new Todolist[5];

    @Override
    public Todolist[] getAllTodo() {
        return todolists;
    }

    private void isFull() {
        if (todolists[todolists.length - 1] != null) {
            Todolist[] tempTodo = todolists;
            todolists = new Todolist[todolists.length * 2];
            for (int j = 0; j < tempTodo.length; j++) {
                todolists[j] = tempTodo[j];
            }
//            System.arraycopy(tempTodo, 0, todolists, 0, tempTodo.length);
        }
    }

    @Override
    public void addTodo(Todolist todolist) {
        isFull();
        for (int i = 0; i < todolists.length; i++) {
            if (todolists[i] == null) {
                todolists[i] = todolist;
                break;
            }
        }
    }

    public boolean isAvailable(int nomor){
        return  (nomor > 0 && nomor <= todolists.length && todolists[nomor-1] != null);
    }

    @Override
    public boolean editTodo(int nomor, Todolist todolist) {
        if (isAvailable(nomor)){
            todolists[nomor-1] = todolist;
            return true;
        }return false;
    }

    @Override
    public boolean removeTodo(int nomor) {
        if (isAvailable(nomor)){
            for (int i = nomor-1; i < todolists.length; i++) {
                if (i < todolists.length-1){
                    todolists[i] = todolists[i+1];
                }else todolists[i] = null;
            }return true;
        }return false;
    }

    @Override
    public Todolist[] searchTodo(String keyword) {
        List<Todolist> list = new ArrayList<>();
        for (int i = 0; i < todolists.length; i++) {
            if (todolists[i].getNama().contains(keyword)){
                list.add(todolists[i]);
            }
        }
        return list.toArray(new Todolist[]{});
    }
}
