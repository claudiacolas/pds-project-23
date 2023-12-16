import React, {useState, useEffect} from 'react'
import { Todo } from "./Todo";
import { TodoForm } from './TodoForm'
import { v4 as uuidv4 } from 'uuid';
import { EditTodoForm } from './EditTodoForm';
import api from '../api/axiosConfig';
uuidv4();

export const TodoWrapper = () => {
    
    const [todos, setTodos] = useState([]);

    const getTodos= async () => {
        try {
            const response = await api.get("/api/v1/todos");
            console.log(response.data);
            setTodos(response.data);
        } catch (err) {
            console.log(err);
        }
    }

    const addTodo = async (title, description) => {
        try {
            await api.post("/api/v1/todos", { title, description });
            const response = await api.get("/api/v1/todos");
            setTodos(response.data);
        } catch (err) {
            console.log(err);
        }
    };
    
    const toggleComplete = async (id) => {
        try {
          const todoToUpdate = todos.find((todo) => todo.id === id);
          const updatedTodo = {
            ...todoToUpdate,
            completed: !todoToUpdate.completed,
          };
      
          const updatedTodos = todos.map((todo) =>
            todo.id === id ? updatedTodo : todo
          );
      
          setTodos(updatedTodos);
          await api.put(`/api/v1/todos/${id}`, updatedTodo);
        } catch (err) {
          console.log(err);
        }
    };
      
    const deleteTodo = async (id) => {
        try {
          await api.delete(`/api/v1/todos/${id}`);
          setTodos(todos.filter((todo) => todo.id !== id));
        } catch (err) {
          console.log(err);
        }
    };

    const editTodo = async (id) => {
        try {
          const updatedTodos = todos.map((todo) =>
            todo.id === id ? { ...todo, isEditing: !todo.isEditing } : todo
          );
          setTodos(updatedTodos);
        } catch (err) {
          console.log(err);
        }
    };
      
      const editTask = async (title, description, id) => {
        try {
          const updatedTodos = todos.map((todo) =>
            todo.id === id ? { ...todo, title, description, isEditing: !todo.isEditing } : todo
          );
          setTodos(updatedTodos);
          await api.put(`/api/v1/todos/${id}`, { title, description });
        } catch (err) {
          console.log(err);
        }
    };

    useEffect(() => {
        getTodos();
    },[])

    return (
        <div className='TodoWrapper'>
            <h1>Get things done!</h1>
            <TodoForm addTodo={addTodo}/>
            
            <h2>My Todos</h2>
            {todos.map(todo => (
                todo.isEditing ? (
                    <EditTodoForm editTodo={editTask} task={todo}/>
                ) : (
                    <Todo task={todo} key={todo.id} 
                    toggleComplete={toggleComplete} deleteTodo={deleteTodo} editTodo={editTodo}/>
                )
            ))}
        </div>
    )
}