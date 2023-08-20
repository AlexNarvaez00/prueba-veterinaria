const ErrorMessages = ({ messages }) => {
  let text = messages.reduce((accum, error) => {
    return error.detail + ", " + accum;
  }, "");
  text = text.charAt(0).toUpperCase() + text.slice(1)

  if (text.length > 1) {
    text = text.substring(0, text.length - 2);
  }
  if (messages.length == 0) {
    return <></>;
  }
  return (
    <>
      <span>{text}</span>
    </>
  );
};
export default ErrorMessages;
