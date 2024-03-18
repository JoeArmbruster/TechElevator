import { createStore as _createStore } from 'vuex';

let timeoutHandle = 0;

export function createStore() {
  return _createStore({
    state: {
      message: ""
    },
    mutations: {

      SET_MESSAGE(state, message) {
      
        if (timeoutHandle) {
          window.clearTimeout(timeoutHandle);
          timeoutHandle = 0;
        }
        // Set the message
        state.message = message;
        
        // Set a timer to remove message
        timeoutHandle = window.setTimeout(() => {
          state.message = "";
          timeoutHandle = 0;
        }, 5000);
      },
      CLEAR_MESSAGE(state) {
        state.message = "";
      },

    },
  })
}
