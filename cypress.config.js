const { defineConfig } = require('cypress')

module.exports = defineConfig({
  e2e: {
    // Configure your E2E tests here
    specPattern: "testChain/cypress/e2e/**/*.{cy,spec}.{js,ts}",
    supportFile: "testChain/cypress/support/e2e.ts",
  },
})