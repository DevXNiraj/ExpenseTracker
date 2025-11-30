const emailInput = document.getElementById('email');
const passwordInput = document.getElementById('password');
const signupBtn = document.getElementById('signup-btn');
const loginBtn = document.getElementById('login-btn');
const switchToLogin = document.getElementById('switch-to-login');
const switchToSignUp = document.getElementById('switch-to-signup');
const formTitle = document.getElementById('form-title');
const message = document.getElementById('message');

// Switch to Login
switchToLogin.addEventListener('click', () => {
  formTitle.textContent = 'Login';
  signupBtn.classList.add('hidden');
  loginBtn.classList.remove('hidden');
  switchToLogin.classList.add('hidden');
  switchToSignUp.classList.remove('hidden');
  message.textContent = '';
});

// Switch to Signup
switchToSignUp.addEventListener('click', () => {
  formTitle.textContent = 'Sign Up';
  signupBtn.classList.remove('hidden');
  loginBtn.classList.add('hidden');
  switchToSignUp.classList.add('hidden');
  switchToLogin.classList.remove('hidden');
  message.textContent = '';
});

// ✅ Password validation function
function isPasswordValid(password) {
  const hasNumber = /\d/;
  const hasLetter = /[a-zA-Z]/;
  return password.length >= 6 && hasNumber.test(password) && hasLetter.test(password);
}

// ✅ SIGNUP
signupBtn.addEventListener('click', () => {
  const email = emailInput.value;
  const password = passwordInput.value;

  if (!email || !password) {
    message.textContent = 'Please enter email & password.';
    return;
  }

  if (!isPasswordValid(password)) {
    message.textContent = 'Password must be ≥6 chars & contain letters + numbers.';
    return;
  }

  localStorage.setItem('userEmail', email);
  localStorage.setItem('userPassword', password);

  message.style.color = "green";
  message.textContent = 'Signup successful! Please login now.';
});

// ✅ LOGIN
loginBtn.addEventListener('click', () => {
  const email = emailInput.value;
  const password = passwordInput.value;
  const storedEmail = localStorage.getItem('userEmail');
  const storedPassword = localStorage.getItem('userPassword');

  if (email === storedEmail && password === storedPassword) {
    message.style.color = "green";
    message.textContent = 'Login successful! Redirecting...';

    setTimeout(() => {
      window.location.href = "index.html";  // Change page after login
    }, 1500);

  } else {
    message.style.color = "red";
    message.textContent = 'Invalid email or password.';
  }
});