// Todo item interface
interface TodoItem {
  taskTitle: string;
  date: string;
}

// Get form and table elements
const todoForm = document.getElementById('todoForm') as HTMLFormElement;
const todoTable = document.getElementById('todoItems') as HTMLTableSectionElement;
const completedList = document.getElementById('completedList') as HTMLUListElement;

// Keep track of todo items
const todoItems: TodoItem[] = [];

// Function to add a todo item to the table
function addTodoItem(item: TodoItem) {
  // Create a new row
  const newRow = todoTable.insertRow();

  // Create table cells for each column
  const serialNumberCell = newRow.insertCell();
  const taskTitleCell = newRow.insertCell();
  const dateCell = newRow.insertCell();
  const doneCell = newRow.insertCell();

  // Set cell values
  serialNumberCell.textContent = (todoTable.rows.length - 1).toString();
  taskTitleCell.textContent = item.taskTitle;
  dateCell.textContent = item.date;
  doneCell.innerHTML = '<button class="doneButton">Done</button>';

  // Add event listener to the "Done" button
  const doneButton = doneCell.querySelector('.doneButton') as HTMLButtonElement;
  doneButton.addEventListener('click', () => {
    moveItemToCompletedList(newRow.rowIndex - 1);
  });
}

// Function to move a completed item to the completed list
function moveItemToCompletedList(index: number) {
  const completedItem = todoItems.splice(index, 1)[0];

  // Create a new list item with a checked checkbox
  const listItem = document.createElement('li');
  listItem.innerHTML = `
    <input type="checkbox" checked>
    ${completedItem.taskTitle}
  `;
  completedList.appendChild(listItem);
}

// Event listener for form submission
todoForm.addEventListener('submit', (e) => {
  e.preventDefault();

  // Get the values from the form
  const taskTitleInput = document.getElementById('taskTitle') as HTMLInputElement;
  const dateInput = document.getElementById('date') as HTMLInputElement;

  const taskTitle = taskTitleInput.value;
  const date = dateInput.value;

  // Create a new todo item
  const todoItem: TodoItem = {
    taskTitle,
    date
  };

  // Add the item to the todoItems array
  todoItems.push(todoItem);

  // Add the item to the table
  addTodoItem(todoItem);

  // Reset the form
  todoForm.reset();
});


