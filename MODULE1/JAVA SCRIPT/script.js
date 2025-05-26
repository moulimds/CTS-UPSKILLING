
// 1. Basics & Setup
console.log("Welcome to the Community Portal");

window.addEventListener('load', () => {
  alert("Page fully loaded");
});

// 2. Syntax, Data Types, and Operators
const eventName = "Community Workshop";
const eventDate = "2025-06-15";
let seatsAvailable = 30;

console.log(`Event: ${eventName}, Date: ${eventDate}, Seats: ${seatsAvailable}`);

// 3. Conditionals, Loops, and Error Handling
const events = [
  { id: 1, name: "Community Workshop", date: "2025-06-15", seats: 30, category: "Workshop", location: "Hall A" },
  { id: 2, name: "Music Festival", date: "2025-05-01", seats: 0, category: "Festival", location: "Park" },
  { id: 3, name: "Health Seminar", date: "2025-07-20", seats: 10, category: "Seminar", location: "Hall B" },
];

// Filter and display valid events (upcoming and with seats)
function isUpcoming(dateStr) {
  const today = new Date();
  return new Date(dateStr) >= today;
}

function displayEvents(eventList) {
  console.log("Valid upcoming events:");
  eventList.forEach(ev => {
    if (isUpcoming(ev.date) && ev.seats > 0) {
      console.log(`${ev.name} on ${ev.date} (${ev.seats} seats available)`);
    }
  });
}

displayEvents(events);

// Registration logic with error handling
function registerUser(eventId) {
  try {
    const event = events.find(ev => ev.id === eventId);
    if (!event) throw new Error("Event not found.");
    if (!isUpcoming(event.date)) throw new Error("Cannot register for past events.");
    if (event.seats <= 0) throw new Error("No seats available.");
    event.seats--; // decrement seats
    console.log(`Registered successfully for ${event.name}. Seats left: ${event.seats}`);
  } catch (err) {
    console.error("Registration failed:", err.message);
  }
}

// 4. Functions, Scope, Closures, Higher-Order Functions
function addEvent(newEvent) {
  events.push(newEvent);
  console.log(`Added event: ${newEvent.name}`);
}

// Closure to track registrations per category
function registrationTracker() {
  const registrations = {};
  return function(category) {
    if (!registrations[category]) registrations[category] = 0;
    registrations[category]++;
    console.log(`Total registrations for ${category}: ${registrations[category]}`);
  };
}

const trackCategoryRegistration = registrationTracker();

// Filter events with callback
function filterEventsByCategory(category, callback) {
  const filtered = events.filter(ev => ev.category === category);
  callback(filtered);
}

// 5. Objects and Prototypes
class Event {
  constructor(id, name, date, seats, category, location) {
    this.id = id;
    this.name = name;
    this.date = date;
    this.seats = seats;
    this.category = category;
    this.location = location;
  }

  checkAvailability() {
    return this.seats > 0 && new Date(this.date) >= new Date();
  }
}

// Add method on prototype (already in class syntax)

// List keys and values of event object
function logEventDetails(eventObj) {
  console.log("Event details:");
  Object.entries(eventObj).forEach(([key, value]) => {
    console.log(`${key}: ${value}`);
  });
}

// 6. Arrays and Methods
// Add new event
addEvent(new Event(4, "Baking Workshop", "2025-08-10", 20, "Workshop", "Kitchen"));

// Filter music events
const musicEvents = events.filter(ev => ev.category === "Festival");
console.log("Music Events:", musicEvents);

// Map to formatted display strings
const displayCards = events.map(ev => `${ev.category} on ${ev.name}`);
console.log("Display Cards:", displayCards);

// 7. DOM Manipulation
const eventContainer = document.querySelector('#eventContainer');

function renderEvents(eventList) {
  if (!eventContainer) return;
  eventContainer.innerHTML = ''; // clear
  eventList.forEach(ev => {
    if (ev.seats > 0 && isUpcoming(ev.date)) {
      const card = document.createElement('div');
      card.className = 'event-card';
      card.innerHTML = `
        <h4>${ev.name}</h4>
        <p>Date: ${ev.date}</p>
        <p>Seats Available: ${ev.seats}</p>
        <button data-id="${ev.id}" class="registerBtn">Register</button>
      `;
      eventContainer.appendChild(card);
    }
  });
}

renderEvents(events);

// 8. Event Handling
document.body.addEventListener('click', (e) => {
  if (e.target.classList.contains('registerBtn')) {
    const eventId = parseInt(e.target.getAttribute('data-id'), 10);
    registerUser(eventId);
    trackCategoryRegistration(events.find(ev => ev.id === eventId).category);
    renderEvents(events); // Update UI seats
  }
});

const categoryFilter = document.querySelector('#categoryFilter');
if (categoryFilter) {
  categoryFilter.addEventListener('change', () => {
    const selected = categoryFilter.value;
    if (selected === 'all') {
      renderEvents(events);
    } else {
      filterEventsByCategory(selected, filteredEvents => renderEvents(filteredEvents));
    }
  });
}

const searchInput = document.querySelector('#searchInput');
if (searchInput) {
  searchInput.addEventListener('keydown', (e) => {
    if (e.key === 'Enter') {
      const query = searchInput.value.toLowerCase();
      const filtered = events.filter(ev => ev.name.toLowerCase().includes(query));
      renderEvents(filtered);
    }
  });
}

// 9. Async JS, Promises, Async/Await
async function fetchEvents() {
  const spinner = document.querySelector('#loadingSpinner');
  try {
    spinner.style.display = 'block';
    // Mock fetch from a local JSON file or API
    const response = await fetch('mock-events.json'); 
    if (!response.ok) throw new Error("Network response was not OK");
    const data = await response.json();
    spinner.style.display = 'none';
    console.log("Fetched events:", data);
    renderEvents(data);
  } catch (err) {
    spinner.style.display = 'none';
    console.error("Fetching events failed:", err);
  }
}

// Uncomment to test fetching
// fetchEvents();

// 10. Modern JavaScript Features (already used in the code)

// 11. Working with Forms
const registrationForm = document.querySelector('#registrationForm');
if (registrationForm) {
  registrationForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const form = e.target;
    const name = form.elements['name'].value.trim();
    const email = form.elements['email'].value.trim();
    const eventType = form.elements['eventType'].value;

    if (!name || !email || !eventType) {
      alert("Please fill all required fields.");
      return;
    }

    console.log(`Registering ${name} (${email}) for ${eventType}`);
    form.reset();
  });
}

// 12. AJAX & Fetch API
function postRegistration(data) {
  console.log("Sending registration data...", data);
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve({ status: "success" });
    }, 1500);
  });
}

if (registrationForm) {
  registrationForm.addEventListener('submit', async (e) => {
    e.preventDefault();
    const form = e.target;
    const formData = {
      name: form.elements['name'].value.trim(),
      email: form.elements['email'].value.trim(),
      eventType: form.elements['eventType'].value
    };

    try {
      const response = await postRegistration(formData);
      if (response.status === "success") {
        alert("Registration successful!");
        form.reset();
      } else {
        alert("Registration failed. Please try again.");
      }
    } catch {
      alert("Error communicating with server.");
    }
  });
}

// 13. Debugging and Testing
// Use browser dev tools; console.logs are added above for tracing.

// 14. jQuery (example snippet, if jQuery loaded)
/*
$('#registerBtn').click(() => {
  alert("Register button clicked!");
});

$('.event-card').fadeIn();

$('.event-card').fadeOut();
*/

// Benefits of React/Vue: Component reusability, reactive UI updates, better state management.

