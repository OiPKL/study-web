<script setup>

const props = defineProps({
    'childColor': Object,
    'myIdx': Number,
    'selectedIdx': Number,
});
const emits = defineEmits(['myClick']);

const clickEvent = () => {
    console.log(props.childColor, '색상을 가진 자식 컴포넌트가 클릭되었습니다.');
    emits('myClick');
}

</script>

<template>
    <div>
        <div @click="clickEvent" :style="{ 'background-color': childColor.color }" class="box"
            :class="{ 'selected': myIdx == selectedIdx }">
            <span>{{ childColor.emoji }}</span>
        </div>
    </div>
</template>

<style scoped>
.box {
  width: 250px;
  height: 250px;
  margin: 10px;
  transition: .2s;

  display: flex;
  align-items: center;
  justify-content: center;
}

.box:hover {
  box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24), 0 17px 50px 0 rgba(0, 0, 0, 0.19);
}


.selected {
  box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24), 0 17px 50px 0 rgba(0, 0, 0, 0.19);
}

span {
    font-size: 50px;
}
</style>