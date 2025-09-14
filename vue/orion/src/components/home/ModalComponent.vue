<template>
  <div v-if="visible" class="modal-overlay" @click.self="close">
    <div class="modal-content">
      <button class="modal-close" @click="close">×</button>
      <hr />
      <slot />
    </div>
  </div>
</template>

<script>
export default {
  name: 'ModalComponent',
  props: {
    visible: {
      type: Boolean,
      required: true
    }
  },
  emits: ['close'],
  methods: {
    close() {
      this.$emit('close');
    }
  }
};
</script>

<style>
.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 999;
}

.modal-content {
  background: #FBB03B;
  padding: 1.5rem;
  border-radius: 8px;
  position: relative;
  max-width: 500px;
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: end;
}

.modal-close {
  background: none;
  border: none;
  font-size: 1.5rem;
  cursor: pointer;
  height: 32px;
}

form.anketa {
  display: flex;
  flex-direction: column;
  width: 100%;
  max-width: 400px;
  margin: 0 auto;
  gap: 16px;
}

form.anketa p {
  text-align: center;
}

.loader{
  width: 100%;
  text-align: center;
}

input[type="date"] {
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
}

input[type="date"] {
  font-family: inherit;
  font-size: 16px;
  color: #000;
  background-color: transparent;
}

input[type="checkbox"] {
  accent-color: gray;
}

input {
  height: 54px;
  width: 100%;
  border: none;
  border-bottom: 1px solid #ccc;
  background: transparent;
  padding: 0 12px;
  font-size: 16px;
  box-sizing: border-box;
  outline: none;
  transition: border-color 0.2s;
}

select {
  height: 54px;
  width: 100%;
  border: none;
  border-bottom: 1px solid #ccc;
  background: transparent;
  padding: 0 12px;
  font-size: 16px;
  box-sizing: border-box;
  outline: none;
  transition: border-color 0.2s;
  color: gray; /* если у тебя тёмный фон */
  appearance: none; /* убирает стрелку браузера */
  -webkit-appearance: none;
  -moz-appearance: none;
  position: relative;
}

textarea{
  width: 100%;
  border: none;
  border-bottom: 1px solid #ccc;
  background: transparent;
  padding: 0 12px;
  font-size: 16px;
  box-sizing: border-box;
  outline: none;
  transition: border-color 0.2s;
}

input:focus {
  border-bottom: 1px solid #007BFF;
}

button {
  height: 54px;
  color: #ffffff;
  border: none;
  background: #1B1B1B;
  border: none;
  font-size: 16px;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  color: #FFFFFF;
  border: 1px solid #FFFFFF;
  background: none;
}

</style>