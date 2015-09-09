package pl.pragmatists.stack;

import static org.assertj.core.api.StrictAssertions.*;

import org.junit.Test;

public class StackTest {

    private static final String ELEMENT = "element";
    private Stack stack = new Stack(99);

    @Test
    public void new_stack_should_be_empty() {
        assertStackSize(0);
    }

    @Test
    public void after_push_stack_is_not_empty() {
        stack.push(ELEMENT);

        assertStackSize(1);
    }

    @Test
    public void after_push_and_pop_stack_is_empty_again() {
        stack.push(ELEMENT);
        stack.pop();

        assertStackSize(0);
    }

    @Test(expected = EmptyStackException.class)
    public void pop_on_empty_stack_throws_exception() {
        stack.pop();
    }

    @Test(expected = FullStackException.class)
    public void cannot_push_a_full_stack() {
        Stack stack = new Stack(0);

        stack.push(ELEMENT);
    }

    @Test
    public void poppedElementIsEqualToPushed() {
        stack.push(ELEMENT);

        String popped = stack.pop();

        assertThat(popped).isEqualTo(ELEMENT);
    }

    @Test
    public void pops_pushed_elements_in_reverse_order() {
        stack.push("first pushed");
        stack.push("second pushed");

        String firstPopped = stack.pop();
        String secondPopped = stack.pop();

        assertThat(firstPopped).isEqualTo("second pushed");
        assertThat(secondPopped).isEqualTo("first pushed");
    }

    private void assertStackSize(int size) {
        assertThat(stack.size()).isEqualTo(size);
    }

}
