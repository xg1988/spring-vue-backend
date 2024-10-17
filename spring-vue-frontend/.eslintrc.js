module.exports = {
    env: {
        node: true,
    },
    extends: [
        'eslint:recommended',
        "plugin:vue/vue3-recommended",
        "**prettier**"
    ],
    rules: {
    'prettier/prettier': [
      'error',
      {
        singleQuote: true,
        semi: true,
        tabWidth: 4,
        trailingComma: 'none',
        printWidth: 140,
        bracketSpacing: true,
        arrowParens: 'avoid',
      },
    ],
  },
}
