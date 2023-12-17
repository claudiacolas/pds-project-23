import React, {useState} from 'react'

export const TodoForm = ({ addTodo }) => {

  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    addTodo(title, description);
    setTitle('');
    setDescription('');
  };

  return (
      <form className="TodoForm" onSubmit={handleSubmit}>
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
        <button type="submit" className="todo-btn" style={{ width: '100%' }}>
          Add task
        </button>
      </form>
    );
};