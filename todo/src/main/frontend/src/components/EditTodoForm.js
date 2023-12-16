import React, { useState } from 'react';

export const EditTodoForm = ({ editTodo, task }) => {

    const [title, setTitle] = useState(task.title);
    const [description, setDescription] = useState(task.description);

    const handleSubmit = (e) => {
        e.preventDefault();
        editTodo(title, description, task.id);
        setTitle('');
        setDescription('');
    };

    return (
        <form className='TodoForm' onSubmit={handleSubmit}>
        <div className="input-container">
          <input
            type="text"
            className="todo-input"
            value={title}
            placeholder="Title"
            onChange={(e) => setTitle(e.target.value)}
            />
            <div className="description-container">
                <textarea
                className="description-input"
                value={description}
                placeholder="Description"
                onChange={(e) => setDescription(e.target.value)}
                />
            </div>
          </div>
            <button type='submit' className='todo-btn'>
                Update task
            </button>
        </form>
    );
};
