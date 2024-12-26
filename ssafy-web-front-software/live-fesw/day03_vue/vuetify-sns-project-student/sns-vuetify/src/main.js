import { createApp } from "vue";

// vuetify
import "vuetify/styles";
import { createVuetify } from "vuetify";
import * as components from "vuetify/components";
import * as directives from "vuetify/directives";
import { aliases, mdi } from "vuetify/iconsets/mdi";

// mdi icons
import "@mdi/font/css/materialdesignicons.css";

import App from "./App.vue";

const app = createApp(App);
const vuetify = createVuetify({
  components,
  directives,
  icons: {
    defaultSet: "mdi",
  },
});

app.use(vuetify).mount("#app");
