import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faPenToSquare, faTrash, faSquareCheck, faSquare } from '@fortawesome/free-solid-svg-icons';

export const Todo = ({ task, toggleComplete, deleteTodo, editTodo }) => {
  return (
    <div className='Todo'>
        <div>
            <p className='todo-title'>{task.title}</p>
            <div className='todo-description'>{task.description}</div>
        </div>
        <div>
        <FontAwesomeIcon
          className={`fa-icon complete-icon ${task.completed ? "completed" : ""}`}
          icon={task.completed ? faSquareCheck : faSquare}
          onClick={() => toggleComplete(task.id)}
        />
        <FontAwesomeIcon className='fa-icon edit-icon' icon={faPenToSquare} onClick={() => editTodo(task.id)}/>
        <FontAwesomeIcon className='fa-icon delete-icon' icon={faTrash} onClick={() => deleteTodo(task.id)}/>
      </div>
    </div>
  );
};
