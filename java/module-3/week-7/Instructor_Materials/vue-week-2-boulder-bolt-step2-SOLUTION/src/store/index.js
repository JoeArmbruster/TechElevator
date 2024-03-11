import { createStore as _createStore } from 'vuex';

export function createStore() {
  return _createStore({
    state: {

      runners: [
        {
          id: 1,
          first_name: "David",
          last_name: "Lawrence",
          city: "Boulder",
          state: "CO",
          time_seconds: 10426
        },
        {
          id: 2,
          first_name: "Marta",
          last_name: "Soledad",
          city: "Phoenix",
          state: "AZ",
          time_seconds: 11358
        },
        {
          id: 3,
          first_name: "Stacy",
          last_name: "Chen",
          city: "Cleveland",
          state: "OH",
          time_seconds: 15359
        },
        {
          id: 4,
          first_name: "Scott",
          last_name: "Simpson",
          city: "San Francisco",
          state: "CA",
          time_seconds: 16426
        },

      ],
    },
    mutations: {},
    // Strict should not be used in production code. It is used here as a
    // learning aid to warn you if state is modified without using a mutation.
    strict: true
  })
}

