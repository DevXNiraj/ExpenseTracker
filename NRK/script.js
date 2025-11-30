// Select DOM elements
const itemInput = document.getElementById("item");
const amountInput = document.getElementById("amount");
const dateInput = document.getElementById("date");
const typeSelect = document.getElementById("type");
const addBtn = document.getElementById("addBtn");
const transactionList = document.getElementById("transactionList");
const incomeTotal = document.getElementById("incomeTotal");
const expenseTotal = document.getElementById("expenseTotal");
const balance = document.getElementById("balance");
const chartCanvas = document.getElementById("chart");

// Load transactions from localStorage or start empty
let transactions = JSON.parse(localStorage.getItem("transactions")) || [];

// Chart instance
let chart;

// Add new transaction
function addTransaction() {
  const item = itemInput.value.trim();
  const amount = parseFloat(amountInput.value);
  const date = dateInput.value || new Date().toISOString().split("T")[0];
  const type = typeSelect.value;

  // Validation
  if (item === "" || isNaN(amount) || amount <= 0) {
    alert("Please enter valid details!");
    return;
  }

  const transaction = {
    id: Date.now(),
    item,
    amount,
    date,
    type
  };

  transactions.push(transaction);
  localStorage.setItem("transactions", JSON.stringify(transactions));

  // Clear inputs
  itemInput.value = "";
  amountInput.value = "";
  dateInput.value = "";

  renderTransactions();
}

// Delete transaction
function deleteTransaction(id) {
  transactions = transactions.filter(t => t.id !== id);
  localStorage.setItem("transactions", JSON.stringify(transactions));
  renderTransactions();
}

// Render all transactions and summary
function renderTransactions() {
  transactionList.innerHTML = "";
  let totalIncome = 0;
  let totalExpense = 0;

  transactions.forEach((t) => {
    const li = document.createElement("li");
    li.innerHTML = `
     ${t.date} -${t.item} :
  <strong style="color:${t.type === 'income' ? 'green' : 'red'};">
    ${t.type === 'income' ? '+' : '-'}₹${t.amount.toFixed(2)}
  </strong>


      </strong>
      <button class="delete-btn" onclick="deleteTransaction(${t.id})">x</button>
    `;
    transactionList.appendChild(li);

    if (t.type === "income") totalIncome += t.amount;
    else totalExpense += t.amount;
  });

  const totalBalance = totalIncome - totalExpense;

  incomeTotal.textContent = totalIncome.toFixed(2);
  expenseTotal.textContent = totalExpense.toFixed(2);
  balance.textContent = totalBalance.toFixed(2);

  renderChart(totalIncome, totalExpense);
}

// Render Chart
function renderChart(income, expense) {
  const data = {
    labels: ["Income", "Expense"],
    datasets: [{
      data: [income, expense],
      backgroundColor: ["#28a745", "#dc3545"]
    }]
  };

  if (chart) chart.destroy();
  chart = new Chart(chartCanvas, {
    type: "doughnut",
    data: data,
  });
}

// Event Listener
addBtn.addEventListener("click", addTransaction);

// Initial Render
renderTransactions();
